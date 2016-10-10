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
        return this.position;
    }

    public Vector3f getPosition(Vector3f vPosition) {
        return vPosition.set(this.position);
    }

    public Vector3f setPosition(Vector3f vPosition) {
        return this.position.set(vPosition);
    }

    public Vector3f setPosition(float x, float y, float z) {
        return this.position.set(x, y, z);
    }

    public Vector3f addPosition(Vector3f vPosition) {
        return this.position.add(vPosition);
    }

    public Vector3f addPosition(float x, float y, float z) {
        return this.position.add(x, y, z);
    }

    public Vector3f subPosition(Vector3f vPosition) {
        return this.position.sub(vPosition);
    }

    public Vector3f subPosition(float x, float y, float z) {
        return this.position.sub(x, y, z);
    }

    public Vector3f getVelocity() {
        return this.velocity;
    }

    public Vector3f getVelocity(Vector3f vVelocity) {
        return vVelocity.set(this.velocity);
    }

    public Vector3f setVelocity(Vector3f vVelocity) {
        return this.velocity.set(vVelocity);
    }

    public Vector3f setVelocity(float x, float y, float z) {
        return this.velocity.set(x, y, z);
    }

    public Vector3f addVelocity(Vector3f vVelocity) {
        return this.velocity.add(vVelocity);
    }

    public Vector3f addVelocity(float x, float y, float z) {
        return this.velocity.add(x, y, z);
    }

    public Vector3f subVelocity(Vector3f vVelocity) {
        return this.velocity.sub(vVelocity);
    }

    public Vector3f subVelocity(float x, float y, float z) {
        return this.velocity.sub(x, y, z);
    }

    public Vector3f getAcceleration() {
        return this.acceleration;
    }

    public Vector3f getAcceleration(Vector3f vAcceleration) {
        return vAcceleration.set(acceleration);
    }

    public Vector3f setAcceleration(Vector3f vAcceleration) {
        return this.acceleration.set(vAcceleration);
    }

    public Vector3f setAcceleration(float x, float y, float z) {
        return this.acceleration.set(x, y, z);
    }

    public Vector3f addAcceleration(Vector3f vAcceleration) {
        return this.acceleration.add(vAcceleration);
    }

    public Vector3f addAcceleration(float x, float y, float z) {
        return this.acceleration.add(x, y, z);
    }

    public Vector3f subAcceleration(Vector3f vAcceleration) {
        return this.acceleration.sub(vAcceleration);
    }

    public Vector3f subAcceleration(float x, float y, float z) {
        return this.acceleration.sub(x, y, z);
    }

    public Vector3f getForceAccum() {
        return this.forceAccum;
    }

    public Vector3f getForceAccum(Vector3f vForceAccum) {
        return vForceAccum.set(this.forceAccum);
    }

    public Vector3f setForceAccum(Vector3f vForceAccum) {
        return this.forceAccum.set(vForceAccum);
    }

    public Vector3f setForceAccum(float x, float y, float z) {
        return this.forceAccum.set(x, y, z);
    }

    public Vector3f addForceAccum(Vector3f vForceAccum) {
        return this.forceAccum.add(vForceAccum);
    }

    public Vector3f addForceAccum(float x, float y, float z) {
        return this.forceAccum.add(x, y, z);
    }

    public Vector3f subForceAccum(Vector3f vForceAccum) {
        return this.forceAccum.sub(vForceAccum);
    }

    public Vector3f subForceAccum(float x, float y, float z) {
        return this.forceAccum.sub(x, y, z);
    }
}
