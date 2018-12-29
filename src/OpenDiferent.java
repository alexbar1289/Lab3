public class OpenDiferent extends Multimedia{//- пример наследования

    public OpenDiferent(String name, String type){ super(name, type); }//метод отдает строки, которые принимает, суперклассу "Multimedia"

    public String Opening() {//пример полиморфизма:
        return "Файл произвольного формата открывается!\n";
    }
}