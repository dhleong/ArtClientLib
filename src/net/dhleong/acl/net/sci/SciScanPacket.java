package net.dhleong.acl.net.sci;

import net.dhleong.acl.net.ShipActionPacket;
import net.dhleong.acl.world.ArtemisObject;

public class SciScanPacket extends ShipActionPacket {

    private static final int FLAGS = 0x0c;
    public SciScanPacket(ArtemisObject target) {
        super(FLAGS, TYPE_SCI_SCAN, target.getId());
    }

}
