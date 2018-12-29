public class OpenText extends Multimedia{//- пример наследования

    public OpenText(String name, String type){ super(name, type); }//метод отдает строки, которые принимает, суперклассу "Multimedia"

    public String Opening() {//пример полиморфизма:
        return "Файл текстового формата открывается!\n";
    }
}
