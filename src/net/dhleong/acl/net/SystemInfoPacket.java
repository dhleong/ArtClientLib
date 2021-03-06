package net.dhleong.acl.net;

import net.dhleong.acl.ArtemisPacket;

@Deprecated
public class SystemInfoPacket extends BaseArtemisPacket {
    
    public static final byte ACTION_CREATE = (byte) 0xff;
    public static final byte ACTION_UPDATE_SYSTEMS = (byte) 0x80;
    /** I dunno, this happens too */
    public static final byte ACTION_UPDATE_SYSTEMS_2 = (byte) 0x00;

    public final boolean isEmpty;

    private final byte mTargetType;
    private final int mTarget;
    private final byte mAction;
    static final byte ACTION_MASK  = (byte) 0xf0;
    
    public SystemInfoPacket(int flags, byte[] bucket) {
        super(0x01, flags, ArtemisPacket.WORLD_TYPE, bucket); // TODO don't save the byte[]?
        
        // only gets the first one, but
        //  they seem to be grouped
        mTargetType = bucket[0];

        isEmpty = mTargetType == 0;
        
        if (!isEmpty) {
            mTarget = PacketParser.getLendInt(bucket, 1);
            mAction = bucket[5];
        } else {
            mTarget = 0;
            mAction = 0;
        }
    }

    public int getTarget() {
        return mTarget;
    }

    public byte getTargetType() {
        return mTargetType;
    }

    public byte getAction() {
        return mAction;
    }

}
