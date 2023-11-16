package kz.pandev.legrambotapi.utils.gson;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

/**
 * java.io.File type adapter for Gson
 * @author ezuykow
 */
public class FileTypeAdapter extends TypeAdapter<File> {
    @Override
    public void write(JsonWriter jsonWriter, File file) throws IOException {
        if (file == null) {
            jsonWriter.nullValue();
        } else {
            jsonWriter.value(Arrays.toString(Files.readAllBytes(file.toPath())));
        }
    }

    @Override
    public File read(JsonReader jsonReader) throws IOException {
        return null; //No needed to deserialize Files
    }
}