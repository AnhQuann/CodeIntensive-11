package base.player;

import base.FrameCounter;
import base.GameObject;
import base.KeyEventPress;
import base.action.Action;

public class ActionFire implements Action {
    FrameCounter fireCounter;
    public ActionFire() {
        this.fireCounter = new FrameCounter(20);
    }

    @Override
    public void run(GameObject master) {
        if (this.fireCounter.run() && KeyEventPress.isFirePress) {
            this.fire(master);
        }
    }

    private void fire(GameObject master) {
        PlayerBulletType1 bullet = GameObject.recycle(PlayerBulletType1.class);
        bullet.position.set(master.position);

        PlayerBulletType2 bullet2 = GameObject.recycle(PlayerBulletType2.class);
        bullet2.position.set(master.position.add(-25, 0));
        bullet2.velocity.set(-5, -5);

        this.fireCounter.reset();
    }

}
