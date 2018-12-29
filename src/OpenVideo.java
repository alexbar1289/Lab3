public class OpenVideo extends Multimedia{//- пример наследования

    public OpenVideo(String name, String type){ super(name, type); }//метод отдает строки, которые принимает, суперклассу "Multimedia"

    public String Opening() {//пример полиморфизма:
        return "Файл видео формата открывается!\n";
    }
}