package com.util;

/**
 * @author xtaod
 */
public class Message {
    String name;
    String content;

    public Message(String stageAddMess, String s) {
        this.name = stageAddMess;
        this.content = s;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
