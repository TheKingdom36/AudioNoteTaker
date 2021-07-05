package AudioApp.AudioNoteTaker.Factories;

public interface AbstractFactory<T> {

    T create(String type);
}
