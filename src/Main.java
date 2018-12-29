   /*
    *   Main.java - файл
    *
    *   Авторское право (С) Удовенко Владислав Валерьевич
    *
    *   Назначение:
    *        Содержит функции, реализующие решение третей задачи.
    *
    *   Описание:
    *        Условие задачи: Спроектировать архитектуру ПО для просмотра тек-стовых,
    *        мультимедийных(фото, аудио, видео) файлов и файлов произвольного формата.
    *        Проектирование выполнить с учетом парадигмы ООП.
    *        В коде программы должны быть реализованы: инкапсуляция, наследование классов и полиморфизм.
    *        Также доработать программу возможностью копирования содержимого одного текстового файла в другой.
    *
    *   Дата создания:
    *        17 октября 2018
    *
    *   История версий:
    *        1.0 beta - реализован основной функционал.
    */

   import java.io.BufferedReader;//запись строк в байтовый входной поток (запись текста в буфер)
   import java.io.IOException; //исключение ввода-вывода
   import java.io.InputStreamReader;//чтение символов из байтового входного потока
   import java.io.File;

    public class Main {

        public static void main(String[] args) throws IOException {//IOException - это предупреждение о возможном исключении ввода-вывода

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Лабораторная работа №3");
            System.out.println("ПЭ - 171 Удовенко Владислав Валерьевич");
            System.out.println("Условие задачи: Спроектировать архитектуру ПО для просмотра тек-стовых, мультимедийных(фото, аудио, видео) файлов и файлов произвольного формата.\n " +
                    "Проектирование выполнить с учетом парадигмы ООП. Также доработать программу возможностью копирования содержимого одного текстового файла в другой.");
            System.out.println("\n\r==================================== 3 ====================================");

            System.out.println("Введите путь к файлу:\n");
            String way = reader.readLine();

            //первый способ изъятия из пути названия и типа файла:
            File f = new File(way);
            String name_type_file = f.getName();//название файла с его типом
            String[] razbiv_name_type = name_type_file.split("\\.");//массив из двух элементов: название файла и его тип

            String name_file = razbiv_name_type[0];//название файла
            String type_file = razbiv_name_type[1];//тип файла

            //второй способ изъятия из пути названия и типа файла (сначала я  так запрограммировал, пока не узнал про способ выше):
            /*String[] razbiv = way.split("\\\\");//массив из элементов пути, разделенных через '\'
            String name_type_file = razbiv[razbiv.length - 1];//Последний элемент, содержащий навание и тип файла
            String[] razbiv_name_type = name_type_file.split("\\.");//массив из двух элементов: название файла и его тип, разделенных точкой
            String name_file = razbiv_name_type[0];//название файла
            String type_file = razbiv_name_type[1];//тип файла*/

            System.out.println("Ваш файл типа: " + type_file + "\n");
            System.out.println("Начнем открытие файла...\n");

            OpenText text = new OpenText(name_file, type_file);
            OpenPicture foto = new OpenPicture(name_file, type_file);
            OpenVideo video = new OpenVideo(name_file, type_file);
            OpenAudio audio = new OpenAudio(name_file, type_file);
            OpenDiferent diff = new OpenDiferent(name_file, type_file);

            switch (type_file) {//проверка формата файла
                //проверка на текстовые форматы:
                case "txt":
                    System.out.println("Нажмите клавишу 1, чтобы открыть файл\n\rНажмите клавишу 2, чтобы копировать содержимое файла в другой файл\n");
                    BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
                    String choice = reader2.readLine();
                    if (choice.equals("1")) {
                        System.out.println(text.Opening() + text.Open_file());
                        break;
                    }
                    else {
                        System.out.println("Введите путь к файлу, в который будет скопировано содержимое.");
                        BufferedReader reader3 = new BufferedReader(new InputStreamReader(System.in));
                        String way2 = reader3.readLine();
                        Multimedia fileWork = null;
                        try {
                            fileWork = new Multimedia();
                            System.out.println("Содержимое успешно скопировано со скоростью прогресса " + fileWork.copy(way, way2) + " c");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    }
                case "rtf":
                    System.out.println("Начнем открытие файла...\n");
                    System.out.println(text.Opening() + text.Open_file()); break;
                case "doc":
                    System.out.println("Начнем открытие файла...\n");
                    System.out.println(text.Opening() + text.Open_file()); break;
                case "pdf":
                    System.out.println("Начнем открытие файла...\n");
                    System.out.println(text.Opening() + text.Open_file()); break;
                //проверка на растровые форматы:
                case "jpg":
                    System.out.println("Начнем открытие файла...\n");
                    System.out.println(foto.Opening() + foto.Open_file()); break;
                case "bmp":
                    System.out.println("Начнем открытие файла...\n");
                    System.out.println(foto.Opening() + foto.Open_file()); break;
                case "png":
                    System.out.println("Начнем открытие файла...\n");
                    System.out.println(foto.Opening() + foto.Open_file()); break;
                case "gif":
                    System.out.println("Начнем открытие файла...\n");
                    System.out.println(foto.Opening() + foto.Open_file()); break;
                //проверка на видео форматы:
                case "mov":
                    System.out.println("Начнем открытие файла...\n");
                    System.out.println(video.Opening() + video.Open_file()); break;
                case "mp4":
                    System.out.println("Начнем открытие файла...\n");
                    System.out.println(video.Opening() + video.Open_file()); break;
                case "avi":
                    System.out.println("Начнем открытие файла...\n");
                    System.out.println(video.Opening() + video.Open_file()); break;
                case "mpeg":
                    System.out.println(video.Opening() + video.Open_file()); break;
                //проверка на аудио форматы:
                case "wav":
                    System.out.println("Начнем открытие файла...\n");
                    System.out.println(audio.Opening() + audio.Open_file()); break;
                case "mp3":
                    System.out.println("Начнем открытие файла...\n");
                    System.out.println(audio.Opening() + audio.Open_file()); break;
                case "aiff":
                    System.out.println("Начнем открытие файла...\n");
                    System.out.println(audio.Opening() + audio.Open_file()); break;
                case "midi":
                    System.out.println("Начнем открытие файла...\n");
                    System.out.println(audio.Opening() + audio.Open_file()); break;
                //проверка на произвольные форматы:
                default:
                    System.out.println("Начнем открытие файла...\n");
                    System.out.println(diff.Opening() + diff.Open_file()); break;
            }
        }
   }