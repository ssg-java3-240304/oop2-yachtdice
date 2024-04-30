package yacht.dice;

public enum InputType {
    GAMESTART("gs"),
    ROLL_DICE("rd'"),
    CHOOSE_SCORE_BORAD("sc");
    private String  status;

    InputType(String  status) {
        this.status = status;
    }

    public static InputType inputType(String i)
    {
        return switch (i)
        {
            case "gs" -> GAMESTART;
            case "rd" -> ROLL_DICE;
            case "sc" -> CHOOSE_SCORE_BORAD;
            default -> throw new IllegalArgumentException("존재하지 않는 상태입니다");
        };
    }
    public String getStatus()
    {
        return status;
    }
}
