package net.dhleong.acl.world;

public abstract class BaseArtemisObject implements ArtemisPositionable {

    protected final int mId;
    public String mName;
    
    private float mX = -1;
    private float mY = -1;
    private float mZ = -1;

    public BaseArtemisObject(int objId, String name) {
        mId = objId;
        mName = name;
    }

    @Override
    public int getId() {
        return mId;
    }
    
    @Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof ArtemisObject))
            return false;
        
        return getId() == ((ArtemisObject)other).getId();
    }
    
    @Override
    public int hashCode() {
        return getId();
    }
    
    @Override
    public String toString() {
        return String.format("(%.0f,%.0f,%.0f)", mX, mY, mZ);
    }

    @Override
    public String getName() {
        return mName;
    }

    @Override
    public float getX() {
        return mX;
    }

    @Override
    public void setX(float mX) {
        this.mX = mX;
    }

    @Override
    public float getY() {
        return mY;
    }

    @Override
    public void setY(float y) {
        mY = y;
    }

    @Override
    public float getZ() {
        return mZ;
    }

    @Override
    public void setZ(float z) {
        mZ = z;
    }
    
    @Override
    public void updateFrom(ArtemisPositionable eng) {
        // names can actually change!
        if (eng.getName() != null)
            mName = eng.getName();
        
        if (eng.getX() != -1) setX(eng.getX());
        if (eng.getY() != -1) setY(eng.getY());
        if (eng.getZ() != -1) setZ(eng.getZ());
    }

}
