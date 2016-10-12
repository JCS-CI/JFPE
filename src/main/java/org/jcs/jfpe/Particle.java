package org.jcs.jfpe;

import org.joml.Vector3f;

public class Particle {

    private float inverseMass = 0f;
    private float damping = 0f;
    private Vector3f position = new Vector3f();
    private Vector3f velocity = new Vector3f();
    private Vector3f acceleration = new Vector3f();
    private Vector3f forceAccum = new Vector3f();

    public void integrate(float duration) {
        if (inverseMass <= 0.0f) return;

        assert (duration > 0.0);

        position.add(velocity.mul(duration, new Vector3f()));

        Vector3f resultingAcc = new Vector3f(acceleration);
        resultingAcc.add(forceAccum.mul(inverseMass, new Vector3f()));

        velocity.add(resultingAcc.mul(duration, new Vector3f()));

        velocity.mul((float) Math.pow(damping, duration));

        clearAccumulator();
    }

    public void clearAccumulator() {
        forceAccum.zero();
    }

    public float getInverseMass() {
        return inverseMass;
    }

    public void setInverseMass(float inverseMass) {
        this.inverseMass = inverseMass;
    }

    public float getMass() {
        if (getInverseMass() == 0) {
            return Float.MAX_VALUE;
        } else {
            return (1.0f / getInverseMass());
        }
    }

    public void setMass(float mass) {
        assert (mass != 0);
        setInverseMass(1.0f / mass);
    }

    public boolean hasFiniteMass() {
        return inverseMass >= 0.0f;
    }

    public float getDamping() {
        return damping;
    }

    public void setDamping(float damping) {
        this.damping = damping;
    }

    public Vector3f getPosition() {
        return position;
    }

    public Vector3f getVelocity() {
        return velocity;
    }

    public Vector3f getAcceleration() {
        return acceleration;
    }

    public Vector3f getForceAccum() {
        return forceAccum;
    }
}
