package kz.pandev.legrambotapi.models.types.passport.credentials.utils.decrypt;

import lombok.Getter;

import javax.crypto.Cipher;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.RSAPrivateCrtKeySpec;

/**
 * RSA OAEP decryptor
 * @author ezuykow
 */
public final class RsaOaep {

    private RsaOaep() {}

    //region API

    static byte[] decrypt(String privateKey, byte[] secret) throws Exception {
        String pkcs8Pem = privateKey
                .replace("-----BEGIN RSA PRIVATE KEY-----", "")
                .replace("-----END RSA PRIVATE KEY-----", "")
                .replaceAll("\\s+", "");
        byte[] pkcs8EncodedBytes = Base64.decode(pkcs8Pem, 0);

        KeyFactory kf = KeyFactory.getInstance("RSA");
        PrivateKey pk = kf.generatePrivate(getRSAKeySpec(pkcs8EncodedBytes));

        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-1AndMGF1Padding");
        cipher.init(Cipher.DECRYPT_MODE, pk);
        return cipher.doFinal(secret);
    }

    //endregion
    //region Utils

    private static RSAPrivateCrtKeySpec getRSAKeySpec(byte[] keyBytes) throws IOException {

        DerParser parser = new DerParser(keyBytes);

        Asn1Object sequence = parser.read();
        if (sequence.getType() != DerParser.SEQUENCE)
            throw new IOException("Invalid DER: not a sequence"); //$NON-NLS-1$

        // Parse inside the sequence
        parser = sequence.getParser();

        parser.read(); // Skip version
        BigInteger modulus = parser.read().getInteger();
        BigInteger publicExp = parser.read().getInteger();
        BigInteger privateExp = parser.read().getInteger();
        BigInteger prime1 = parser.read().getInteger();
        BigInteger prime2 = parser.read().getInteger();
        BigInteger exp1 = parser.read().getInteger();
        BigInteger exp2 = parser.read().getInteger();
        BigInteger crtCoef = parser.read().getInteger();

        return new RSAPrivateCrtKeySpec(
                modulus, publicExp, privateExp, prime1, prime2,
                exp1, exp2, crtCoef);
    }

    @SuppressWarnings("unused")
    private static class DerParser {

        // Classes
        public static final int UNIVERSAL = 0x00;
        public static final int APPLICATION = 0x40;
        public static final int CONTEXT = 0x80;
        public static final int PRIVATE = 0xC0;

        // Constructed Flag
        public static final int CONSTRUCTED = 0x20;

        // Tag and data types
        public static final int ANY = 0x00;
        public static final int BOOLEAN = 0x01;
        public static final int INTEGER = 0x02;
        public static final int BIT_STRING = 0x03;
        public static final int OCTET_STRING = 0x04;
        public static final int NULL = 0x05;
        public static final int OBJECT_IDENTIFIER = 0x06;
        public static final int REAL = 0x09;
        public static final int ENUMERATED = 0x0a;
        public static final int RELATIVE_OID = 0x0d;

        public static final int SEQUENCE = 0x10;
        public static final int SET = 0x11;

        public static final int NUMERIC_STRING = 0x12;
        public static final int PRINTABLE_STRING = 0x13;
        public static final int T61_STRING = 0x14;
        public static final int VIDEOTEX_STRING = 0x15;
        public static final int IA5_STRING = 0x16;
        public static final int GRAPHIC_STRING = 0x19;
        public static final int ISO646_STRING = 0x1A;
        public static final int GENERAL_STRING = 0x1B;

        public static final int UTF8_STRING = 0x0C;
        public static final int UNIVERSAL_STRING = 0x1C;
        public static final int BMP_STRING = 0x1E;

        public static final int UTC_TIME = 0x17;
        public static final int GENERALIZED_TIME = 0x18;

        protected InputStream in;

        /**
         * Create a new DER decoder from an input stream.
         *
         * @param in The DER encoded stream
         */
        public DerParser(InputStream in) {
            this.in = in;
        }

        /**
         * Create a new DER decoder from a byte array.
         *
         * @param bytes The encoded bytes
         */
        public DerParser(byte[] bytes) {
            this(new ByteArrayInputStream(bytes));
        }

        /**
         * Read next object. If it's constructed, the value holds
         * encoded content, and it should be parsed by a new
         * parser from <code>Asn1Object.getParser</code>.
         *
         * @return A object
         */
        public Asn1Object read() throws IOException {
            int tag = in.read();

            if (tag == -1)
                throw new IOException("Invalid DER: stream too short, missing tag"); //$NON-NLS-1$

            int length = getLength();

            byte[] value = new byte[length];
            int n = in.read(value);
            if (n < length)
                throw new IOException("Invalid DER: stream too short, missing value"); //$NON-NLS-1$

            return new Asn1Object(tag, length, value);
        }

        /**
         * Decode the length of the field. Can only support length
         * encoding up to 4 octets.
         * <p>
         * <p/>In BER/DER encoding, length can be encoded in 2 forms,
         * <ul>
         * <li>Short form. One octet. Bit 8 has value "0" and bits 7-1
         * give the length.
         * <li>Long form. Two to 127 octets (only 4 is supported here).
         * Bit 8 of first octet has value "1" and bits 7-1 give the
         * number of additional length octets. Second and following
         * octets give the length, base 256, most significant digit first.
         * </ul>
         *
         * @return The length as integer
         */
        private int getLength() throws IOException {

            int i = in.read();
            if (i == -1)
                throw new IOException("Invalid DER: length missing"); //$NON-NLS-1$

            // A single byte short length
            if ((i & ~0x7F) == 0)
                return i;

            int num = i & 0x7F;

            // We can't handle length longer than 4 bytes
            if (i == 0xFF || num > 4)
                throw new IOException("Invalid DER: length field too big (" //$NON-NLS-1$
                        + i + ")"); //$NON-NLS-1$

            byte[] bytes = new byte[num];
            int n = in.read(bytes);
            if (n < num)
                throw new IOException("Invalid DER: length too short"); //$NON-NLS-1$

            return new BigInteger(1, bytes).intValue();
        }

    }

    /**
     * An ASN.1 TLV. The object is not parsed. It can
     * only handle integers and strings.
     *
     * @author zhang
     */
    private static class Asn1Object {

        @Getter
        protected final int type;
        @Getter
        protected final int length;
        @Getter
        protected final byte[] value;
        protected final int tag;

        /**
         * Construct a ASN.1 TLV. The TLV could be either a
         * constructed or primitive entity.
         * <p>
         * <p/>The first byte in DER encoding is made of following fields,
         * <pre>
         * -------------------------------------------------
         * |Bit 8|Bit 7|Bit 6|Bit 5|Bit 4|Bit 3|Bit 2|Bit 1|
         * -------------------------------------------------
         * |  Class    | CF  |     +      Type             |
         * -------------------------------------------------
         * </pre>
         * <ul>
         * <li>Class: Universal, Application, Context or Private
         * <li>CF: Constructed flag. If 1, the field is constructed.
         * <li>Type: This is actually called tag in ASN.1. It
         * indicates data type (Integer, String) or a construct
         * (sequence, choice, set).
         * </ul>
         *
         * @param tag    Tag or Identifier
         * @param length Length of the field
         * @param value  Encoded octet string for the field.
         */
        public Asn1Object(int tag, int length, byte[] value) {
            this.tag = tag;
            this.type = tag & 0x1F;
            this.length = length;
            this.value = value;
        }

        public boolean isConstructed() {
            return (tag & DerParser.CONSTRUCTED) == DerParser.CONSTRUCTED;
        }

        /**
         * For constructed field, return a parser for its content.
         *
         * @return A parser for the construct.
         * @throws IOException when not constructed
         */
        public DerParser getParser() throws IOException {
            if (!isConstructed())
                throw new IOException("Invalid DER: can't parse primitive entity"); //$NON-NLS-1$

            return new DerParser(value);
        }

        /**
         * Get the value as integer
         *
         * @return BigInteger
         * @throws IOException invalid der
         */
        public BigInteger getInteger() throws IOException {
            if (type != DerParser.INTEGER)
                throw new IOException("Invalid DER: object is not integer"); //$NON-NLS-1$

            return new BigInteger(value);
        }
    }

    //endregion
}