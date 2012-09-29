package net.dhleong.acl;

import net.dhleong.acl.net.BaseArtemisPacket;
import net.dhleong.acl.net.ObjUpdatePacket;
import net.dhleong.acl.net.PlayerUpdatePacket;

public class PacketTestingRunner {
    
    public static final void main(String[] args) {
        String[] tests = new String[]{
                "027c070000dd3a6f007c04000000460037003100000000000000cdcc4c3f6f12833b89130000a94ec3473250c3474215813ed0cc4cbed0cccc3e000096430000964300001643000016433518000000d27f023fe4353f3f16bb0a3f4f7fda3e1314d63e027d070000dd3a6f007c04000000500037003400000000000000cdcc4c3f6f12833b89130000a94ec347b2f89f414215813ed0cc4cbed0cccc3e000096430000964300001643000016433623000000e2f5f03e387ce83e6b121c3fc68b623ffe60e53e00000000",
                "02470c0000853a40027c040000005900330032000000000000002d0c9247c3c1ba464215813ed0cc4cbed0cccc3e22000000002821fa3e2cee623fc6ad2f3fb3ac0c3fe9fbc03e02480c0000ffffffff7f040000004f003100360000000000803f00000000cdcc4c3f6f12833b010000008a1300003df02b470000000001189f47000000004215813ed0cc4cbed0cccc3e0000000000af430000af430000964300009643010043100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000b0f5d73e2607133f1e09423f875ff63ebfba453f00000000",
                "0262080000ff3ffffd7f0400000047003900350000000000803f000000009a99993e6f12033b01000000d0070000b2606043000000006afb9c47000000004215013ed0ccccbd9a99993e0000204200002042000020420000204201000443000000000000000000000000000000000000000000000000000000000000000000000000000000000000001d7f0e3f4265543f8bde2b3f506ac13e2011433f00000000",
                "02b4050000fb3a5f007c040000005a003800320000000000803f9a99993e6f12033b01000000d0070000654fc347a33c53474215013ed0ccccbd9a99993e00002042000020420000204200002042010021000000b6b4743f5f4cfc3e0173003fd045353fcf0f013f02b5050000ffffffff7f0400000056003000370000000000803f000000009a99993e6f12033b01000000d0070000654fc3470000000067a75447000000004215013ed0ccccbd9a99993e000000000020420000204200002042000020420100002600000000000000000000000000000000000000000000000000000000000000000000000000000000000000001714253f858dc23ea4d06b3f32e4323f0cbb053f00000000",
                "03040d0000ffffffff0705000000440065003900350000000000803f0efeff3e3333333f6f12033b00000000dd050000bcc7634700000000abd39f46000000001cafc73658a365bf3333333f00000000a0420000a0420000a0420000a042010000000000000000000000000000000000000000000000000000000000000000000000000000c05c133f6f3db73e781b3c3fc834173f5b08473f03050d0000ffffffff0705000000440065003400300000000000803fa0feff3e3333333f6f12033b00000000dd05000028ef5b47000000006760824700000000b3df9336aa5821c03333333f01000000a0420000a0420000a0420000a04201000000000000000000000000000000000000000000000000000000000000000000000000000066a5663f3287193f0659363fb0a0be3e4a03253f03060d0000ffffffff0705000000540072003300320000000000803f8800003f9a99993e6f12033b00000000dc050000174ecd46000000007508a04700000000cbc155b61da948409a99993e0000000020420000204200002042000020420100000000000000000000000000000000000000000000000000000000000000000000000000008742dd3e1094213f41a1533f0b91eb3e78d9083f03070d0000ffffffff0705000000440065003000380000000000803ff8fcff3e3333333f6f12033b00000000dd0500002364ed4600000000d28f664700000000c6f919373e8f1a403333333f00004eb62e410000a0420000a0420000a042010000000000000000000000000000000000000000000000000000000000000000000000000000c5d2fb3e6a81013fd2d7023f34dc333f57a7de3e03080d0000ffffffff0705000000540072003600330000000000803ff201003f9a99993e6f12033b00000000dc050000ae1a974700000000607791470000000070a747b776b0f1bf9a99993e010000002042000020420000204200002042010000000000000000000000000000000000000000000000000000000000000000000000000000d55e9d3ed7a81e3f28b02d3f88622a3f6072163f00000000",
                "0325080000ffffffff0705000000540072003900390000000000803f0300003f9a99993e6f12033b00000000dc0500000d05124700000000ea87d246000000001be214b04463fc3d9a99993e010000002042000020420000204200002042010000000000000000000000000000000000000000000000000000000000000000000000000000c8bd303ff4f5f93ed06b013ffca14a3f6aa5013f0326080000ffffffff0705000000440065003600320000000000803f0000003f3333333f6f12033b00000000dd050000aafd4b4700000000ceac9a47000000000000000020223dc0d0cccc3e00000000a0420000a0420000a0420000a042010000000000000000000000000000000000000000000000000000000000000000000000000000a90e3b3f18c8253f92bd153f5f30493fce05e73e0327080000ffffffff0705000000540072003500370000000000803ff8ffff3e9a99993e6f12033b00000000dc050000587d944700000000e038a24700000000d5be6f32f3edf2bf9a99993e0000000020420000204200002042000020420100000000000000000000000000000000000000000000000000000000000000000000000000000f0aa13e201a5d3f3c48843e5c25613f52fb283f0328080000ffffffff0705000000440065003700340000000000803f0000003f3333333f6f12033b00000000dd050000ea6ea3470000000091bda847000000000000000076462dc0d0cccc3e00000000a0420000a0420000a0420000a0420100000000000000000000000000000000000000000000000000000000000000000000000000008227413f33d1ff3ee45b0b3fc790163f40e0393f0329080000ffffffff0705000000540072003700390000000000803ff8ffff3e9a99993e6f12033b00000000dc0500009de48d47000000000232874700000000fb90bf32c097ddbf9a99993e000000002042000020420000204200002042010000000000000000000000000000000000000000000000000000000000000000000000000000995d193f4895573ff27f123f7488533fea38db3e032a080000ffffffff0705000000440065003500310000000000803f0000003f3333333f6f12033b00000000dd050000e492014700000000f5dd024700000000c3838c31febd673fd0cccc3e00000000a0420000a0420000a0420000a042010000000000000000000000000000000000000000000000000000000000000000000000000000bb5baa3e00e0193f2ab02e3f034c1b3f76d0543f00000000",
                "03be050000800a0000007679fc466160bf4625b347b703bf050000800a000000a6336c47810b45472fab473703c0050000844a00000018fcff3e9c1bfe466452204717ab4737010003c1050000801a000000ac25a44745f7724777b2c7b710bc3ec003c2050000840a00000030f8ff3eb640324720335b47e89cc73700000000",
                "03be050000841a000000f201003f5fba0f4769e5d1460aa247b7d6f28a3f03bf05000080aa00000011568a471053424717a61937588d173f17f2ecc003c0050000840a00000018fcff3e8f65a6469e6e1247b8b2473703c1050000841a000000e403003fce8ba0473c70454720b1c7b7a0b63ec003c2050000800a000000e7ae38473f6c4847d290c73700000000",
                "033e0e0000800a0000008b401e4703b2bd4682fa9134033f0e0000800a000000fd44ae462cc73e475e9007b503400e0000800a000000aad63e47040daa47080fa0b503410e0000848a8030003000003fc43a8d4723040c479fc482b5000080c1d74f7d3f122f7d3f9c707d3f03420e0000840a0000001500003fc5559b46e6eee34641f3eab400000000",
                "033e0e0000841a0000001811003fb3e4364749c1f6468eb3d4b857a13e3f033f0e0000800a000000bde2f0462c8d2f471790c7b703420e0000848a803800fa00003fc53dd846636d0647397ac7b6000000c176be7f3f0000803fb19d7f3f3bdf7f3f00000000",
        };
        
        testOtherShips(tests);
        
        String[] plrTests = new String[] {
                "01e803000080000000fe81c101000000a79bc43d0f72253f9de7263f2b5d283fcdf4293f8e4b2b3f67892c3f873e2e3fabb82f3f000000000000000008080800000000",
                "01e8030000800000007ee07000000000b3f4ed420cc7ba3c74029a3cb57b723c7bf2303c14b7d13b6e12033b0000803f0000803f0000803f00000000000000",
                "01e803000000100000fe010000000000114e1a0c17506f3f89236c3f33f44e3f0dee4d3fe7e74c3f7ae10b3f95296d3f5476313f00000000",
                "013906000080100000be050000000000f33077444ba2ab2c3ac6373cde2d903cf9d4143e67a4ff3e1da51e3f84d6d83dcdaa263f0000803f00000000",
                "01e8030000ffffffffffffffffffff0000000000000000000000003f9a99193f6f12833b010013007a44000001000000000000000050434700000000005043470000000000000000db0f49400000000000000800000041007200740065006d006900730000000000a0420000a0420000a0420000a0420000000001005043480000080000000000000000000000000000000000000000000000000000000000000000000000000000000000abaaaa3eabaaaa3eabaaaa3eabaaaa3eabaaaa3eabaaaa3eabaaaa3eabaaaa3e0000000000000000080206040d2800080429000c049005990335343232000000000000000000000000000000000233009800000000",
                "01e8030000ffffffffffffffffffff0000000000000000000000003f9a99193f6f12833b010040007a44000001000000000000000050434700000000005043470000000000000000db0f49400000000000000800000041007200740065006d006900730000000000a0420000a0420000a0420000a0420000000000005043480000080000000000000000000000000000000000000000000000000000000000000000000000000000000000abaaaa3eabaaaa3eabaaaa3eabaaaa3eabaaaa3eabaaaa3eabaaaa3eabaaaa3e0000000000000000080206040d2800080429000c049005990335343232000000000000000000000000000000000233009800000000",
                "01e803000080000002000000000000004e007a440100000000",
                "0194070000bf2af92400fe01fe0f800000000000000000000000003f9a99193f6f12833b0120d1794401000000a0413a47523f3847db0f49400800000041007200740065006d006900730000000000a0420000a0420000a0420000a0420050434808abaaaa3eabaaaa3eabaaaa3eabaaaa3eabaaaa3eabaaaa3eabaaaa3eabaaaa3e080206040dffffffff3d010804010000008c5a990338000c04e06fe3037000000000",
                
        };
        
        testPlayers(plrTests);
    }

    private static void testOtherShips(String[] tests) {
        for (String s : tests) {
            byte[] bytes = hexStringToByteArray(s);
            if (!BaseArtemisPacket.byteArrayToHexString(bytes).equals(s))
                throw new RuntimeException("byte conversion fail");
            
            System.out.println();
            ObjUpdatePacket pkt = new ObjUpdatePacket(bytes);
            pkt.debugPrint();
            System.out.println("--> " + pkt);
            System.out.println();
        }
    }

    private static void testPlayers(String[] plrTests) {
        for (String s : plrTests) {
            byte[] bytes = hexStringToByteArray(s);
            
            System.out.println();
            PlayerUpdatePacket pkt = new PlayerUpdatePacket(bytes);
            pkt.debugPrint();
            System.out.println("--> " + pkt);
            System.out.println();
        }
    }

    /** from stack overflow */
    public static byte[] hexStringToByteArray(String s) {
        s = s.toUpperCase(); // yes?
        
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                                 + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
}
