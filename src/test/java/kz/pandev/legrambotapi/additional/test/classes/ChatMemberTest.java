package kz.pandev.legrambotapi.additional.test.classes;

import kz.pandev.legrambotapi.models.types.common.chat.member.ChatMember;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author ezuykow
 */
public class ChatMemberTest {

    public static void check(ChatMember chatMember) {
        assertNotNull(chatMember.getUser());
        assertNotNull(chatMember.getStatus());
        UserTest.checkUser(chatMember.getUser(), chatMember.getStatus() == ChatMember.MemberStatus.CREATOR);
    }
}