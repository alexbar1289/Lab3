public class OpenAudio extends Multimedia{//- пример наследования

    public OpenAudio(String name, String type){ super(name, type); }//метод отдает строки, которые принимает, суперклассу "Multimedia"

    public String Opening() {//пример полиморфизма:
        return "Файл аудио формата открывается!\n";
    }
}