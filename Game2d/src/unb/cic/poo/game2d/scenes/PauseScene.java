package unb.cic.poo.game2d.scenes;

import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.MenuScene.IOnMenuItemClickListener;
import org.andengine.entity.scene.menu.item.IMenuItem;

import unb.cic.poo.game2d.scenes.SceneManager.SceneType;
/*Essa cena futuramente ser� a cena de pausa, com op��es de configura��es
 *no lugar do sprite que simplesmente � colocado na GameScene
 */
public class PauseScene extends BaseScene implements IOnMenuItemClickListener{
	private PauseScene pauseChildScene;

	@Override
	public void createScene() {
		//pauseChildScene = new PauseScene(camera);
		
	}

	@Override
	public void onBackKeyPressed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SceneType getSceneType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void disposeScene() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem,
			float pMenuItemLocalX, float pMenuItemLocalY) {
		// TODO Auto-generated method stub
		return false;
	}

}
