package wellink.test.task.enums;

/**
 * Цвета одежды
 */
public enum Color {

    BLACK("#000000"),
    GRAY("#808080"),
    SILVER("#C0C0C0"),
    WHITE("#FFFFFF"),
    FUCHSIA("#FF00FF"),
    PURPLE("#800080"),
    RED("#FF0000"),
    MAROON("#800000"),
    YELLOW("#FFFF00"),
    OLIVE("#808000"),
    LIME("#00FF00"),
    GREEN("#008000"),
    AQUA("#00FFFF"),
    TEAL("#008080"),
    BLUE("#0000FF"),
    NAVY("#000080");

    private String HEX;

    Color(String HEX) {
        this.HEX = HEX;
    }

    public String getHEX() {
        return HEX;
    }
}
