package strangecraft.proxies;

import cpw.mods.fml.client.registry.RenderingRegistry;



public class ClientProxy extends CommonProxy {

		@Override
		public void initSounds() {
			//new SoundHandler();
		}

		@Override
		public void initRenderers() {
			//RenderingRegistry.registerEntityRenderingHandler(EntitySpaceship.class, new RenderSpaceship());
		}	
		
}
