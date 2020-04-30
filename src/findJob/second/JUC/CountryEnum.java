package findJob.second.JUC;

/**
 * @author 李聪
 * @date 2020/1/21 14:38
 */
public enum CountryEnum {
    ONE(1,"齐"),TWO(2,"楚"),THREE(3,"燕"),FOUR(4,"赵"),FIVE(5,"魏"),SIX(6,"韩");
    private Integer retCode;
    private String retMessage;

    public Integer getRetCode() {
        return retCode;
    }

    public void setRetCode(Integer retCode) {
        this.retCode = retCode;
    }

    public String getRetMessage() {
        return retMessage;
    }

    public void setRetMessage(String retMessage) {
        this.retMessage = retMessage;
    }

    CountryEnum(Integer retCode, String retMessage) {
        this.retCode = retCode;
        this.retMessage = retMessage;
    }

    public static CountryEnum forEach_CountryEnum(int index) {
        CountryEnum[] myArray = CountryEnum.values();
        for (CountryEnum countryEnum : myArray) {
            if(index == countryEnum.getRetCode()) {
                return countryEnum;
            }
        }
        return null;
    }
}
