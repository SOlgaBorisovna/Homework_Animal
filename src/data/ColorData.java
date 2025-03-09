package data;

public enum ColorData {

    RED("Красный");

    private String colorName;

    ColorData(String colorName){
        this.colorName = colorName;
    }

    public String getColorName(){
        return colorName;
    }
}
