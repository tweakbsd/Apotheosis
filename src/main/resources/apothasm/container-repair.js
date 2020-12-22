function initializeCoreMod() {
    return {
        'apothanvilcontainer': {
            'target': {
                'type': 'METHOD',
                'class': 'net.minecraft.inventory.container.RepairContainer',
                'methodName': 'func_82848_d',
                'methodDesc': '()V'
            },
            'transformer': function(method) {
                print('[ApotheosisCore]: Patching RepairContainer#updateRepairOutput');

                var ASMAPI = Java.type('net.minecraftforge.coremod.api.ASMAPI');
                var Opcodes = Java.type('org.objectweb.asm.Opcodes');
                var VarInsnNode = Java.type('org.objectweb.asm.tree.VarInsnNode');
                var MethodInsnNode = Java.type('org.objectweb.asm.tree.MethodInsnNode');
                var LdcInsnNode = Java.type('org.objectweb.asm.tree.LdcInsnNode');
                var InsnList = Java.type('org.objectweb.asm.tree.InsnList');
                var instr = method.instructions;

                var ix = 0;
                var levelRestriction = null;
                var i;
                for (i = 0; i < instr.size(); i++) {
                    var n = instr.get(i);
                    if (n.getOpcode() == Opcodes.BIPUSH && n.operand.equals(40)) {
                        if (ix++ == 2) {
                            levelRestriction = n;
                        }
                    }
                }

                instr.set(levelRestriction, new LdcInsnNode(0x7fffffff));
                print('[ApotheosisCore]: Successfully removed the anvil level cap.');

                return method;
            }
        }
    }
}