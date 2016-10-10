package org.jcs.jfpe;

public class Firework extends Particle {

    private int type = -1;
    private float age = -1f;

    public boolean update(float duration) {

        // Update our physical state
        integrate(duration);

        // We work backwards from our age to zero.
        age -= duration;

        return !(age < 0 || getPosition().y < 0);
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public float getAge() {
        return age;
    }

    public void setAge(float age) {
        this.age = age;
    }
}
