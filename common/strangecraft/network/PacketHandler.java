package strangecraft.network;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import strangecraft.ModInformation;
import strangecraft.client.interfaces.ContainerLabbench;
import strangecraft.tileentites.TileEntityLabBench;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler {

	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {
		ByteArrayDataInput reader = ByteStreams.newDataInput(packet.data);
		
		EntityPlayer entityPlayer = (EntityPlayer)player;
		
		byte packetId = reader.readByte();
		
		switch (packetId) {
			case 0:
				byte type = reader.readByte();
				byte val = reader.readByte();
				Container container = entityPlayer.openContainer;
				if (container != null && container instanceof ContainerLabbench) {
					TileEntityLabBench machine = ((ContainerLabbench)container).getMachine();
					machine.receiveInterfaceEvent(type, val);
				}
				break;
		}
	}
	
	public static void sendInterfacePacket(byte type, byte val) {
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		DataOutputStream dataStream = new DataOutputStream(byteStream);

		try {
			dataStream.writeByte((byte)0);
			dataStream.writeByte(type);
			dataStream.writeByte(val);			
			
			PacketDispatcher.sendPacketToServer(PacketDispatcher.getPacket(ModInformation.CHANNEL, byteStream.toByteArray()));
		}catch(IOException ex) {
			System.err.append("Failed to send button click packet");
		}
	}	

}
