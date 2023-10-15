package module6.lesson4.task3;

public class Message {

    private final String msg;
    private final int id;

    public Message(String str, int id) {
        this.msg = str;
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public int getId() {
        return id;
    }
}
