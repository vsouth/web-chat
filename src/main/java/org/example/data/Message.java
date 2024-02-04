package org.example.data;

public class Message {
    private final String senderLogin;
    private final String senderName;
    private final String text;

    public Message(String senderLogin, String senderName, String text) {
        this.senderLogin = senderLogin;
        this.senderName = senderName;
        this.text = text;
    }

    public String getSenderLogin() {
        return senderLogin;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getText() {
        return text;
    }
}
