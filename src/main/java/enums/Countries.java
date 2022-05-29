package enums;

public enum Countries {
    RUSSIA("Россия"),
    UNDEFINED("Не выбрано");

    private String translate;

    Countries(String translate) {
        this.translate = translate;
    }

    public String getTranslate() {
        return translate;
    }
}
