package sample.model;

public abstract class DummyLift {
    protected StringBuilder ErrorMessage = new StringBuilder("Ой, что-то пошло не так");

    public abstract StringBuilder getErrorMessage ();
}
