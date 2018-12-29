public class OpenPicture extends Multimedia{//- пример наследования

    public OpenPicture(String name, String type){ super(name, type); }//метод отдает строки, которые принимает, суперклассу родителю

    public String Opening() {//пример полиморфизма:
        return "Файл растрового формата открывается!\n";
    }
}