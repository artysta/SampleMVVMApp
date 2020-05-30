package pl.adriankurek.samplemvvmapp.models;

public class User {
    private String name;
    private int birthYear;
    private static String[] sampleNames = {
            "Elliot",
            "Darlene",
            "Angela",
            "Tyrell",
            "MrRobot",
            "Gideon",
            "Trenton",
            "Krista",
            "Saul",
            "Jimmy",
            "Mike",
            "Kim",
            "Nacho",
            "Chuck"
    };

    public User(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    public User() { }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public static User getRandomUser() {
        User user = new User();

        user.name = sampleNames[(int) (Math.random() * sampleNames.length)];
        user.birthYear = (int) (Math.random() * 25) + 1975;

        return user;
    }
}
