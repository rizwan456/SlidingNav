package droids.rizz.slidingnav;

public class Menu {
    int icon;
    String Name;

    public Menu(int icon, String name) {
        this.icon = icon;
        Name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
