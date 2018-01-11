package ai.dragonvalley;

import l2f.commons.util.Rnd;
import l2f.gameserver.Config;
import l2f.gameserver.ai.CtrlEvent;
import l2f.gameserver.ai.Fighter;
import l2f.gameserver.model.Creature;
import l2f.gameserver.model.instances.NpcInstance;
import l2f.gameserver.utils.NpcUtils;

/**
 * @author Aro 
 * 
 * Drakos Warrior(22822)
 * Spawns a pack of four Drakos Assassin (22823) when attacked.
 */

public class DrakosWarrior extends Fighter
{

    public DrakosWarrior(NpcInstance actor) 
    {
        super(actor);
    }

    @Override
    protected void onEvtAttacked(Creature attacker, int damage) 
    {
        if (Rnd.chance(Config.DWARRIOR_MS_CHANCE)) 
        {
            NpcInstance actor = getActor();
            for (int i = 0; i < 4; i++)
            {
                NpcInstance n = NpcUtils.spawnSingle(22823, (actor.getX() + Rnd.get(-100, 100)), (actor.getY() + Rnd.get(-100, 100)), actor.getZ());
                n.getAI().notifyEvent(CtrlEvent.EVT_AGGRESSION, attacker, 2);
            }
        }
        super.onEvtAttacked(attacker, damage);
    }
}
