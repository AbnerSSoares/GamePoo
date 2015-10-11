package unb.cic.poo.game2d;

import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.MoveByModifier;
import org.andengine.util.modifier.IModifier;

//Inimigo B�sico

public class CommonEnemy extends Enemy{
	private static final int DEFAULT_COMMON_ENEMY_SPEED = 150;
	//private static final int COMMON_ENEMY_HEIGHT = GameActivity.CAMERA_HEIGHT/22; //32
	private static final int COMMON_ENEMY_WIDTH = GameActivity.CAMERA_WIDTH/40; //32
	private static final int COMMON_ENEMY_LIFE = 1;
	
	public CommonEnemy(float pX, float pY) {
		super(pX, pY, ResourceManager.enemyTextureRegion, 
				GameManager.getInstance().getGameEngine().getVertexBufferObjectManager());
		this.speed = DEFAULT_COMMON_ENEMY_SPEED;
		this.life = COMMON_ENEMY_LIFE;
		this.setMovement();
	}
	
	private void setMovement(){
		float distance = GameManager.getInstance().getGameCamera().getWidth();
		float durationTime = distance/this.speed;
		
		MoveByModifier moveByModifier = new MoveByModifier(durationTime, -distance-COMMON_ENEMY_WIDTH, 0);
		moveByModifier.addModifierListener(this);
		
		moveByModifier.setAutoUnregisterWhenFinished(true);
		this.registerEntityModifier(moveByModifier);
	}
	
	//Verifica se o inimigo colide com o player, caso verdadeiro, o jogo para (Game Over).
	protected void onManagedUpdate(float pSecondsElapsed) {
		if(this.collidesWith(GameManager.getInstance().getPlayer())){
			GameManager.getInstance().getGameEngine().stop();
		}
		super.onManagedUpdate(pSecondsElapsed);
	}

	@Override
	public void shoot() {
	}
	
	//método responsável por remover o inimigo da tela.
	@Override
	public void removeEnemy() {
		GameManager.getInstance().getEnemies().remove(this);
		GameManager.getInstance().getGameScene().detachChild(this);
	}

	@Override
	public void onModifierStarted(IModifier<IEntity> pModifier, IEntity pItem) {
	}
	
	@Override
	public void onModifierFinished(IModifier<IEntity> pModifier, IEntity pItem) {
		this.movementFinished = true;
	}
}
