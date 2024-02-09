package luke.rancidresources;

import turniplabs.halplibe.helper.SoundHelper;
import turniplabs.halplibe.util.ClientStartEntrypoint;

public class RancidClient implements ClientStartEntrypoint {
	@Override
	public void beforeClientStart() {
		SoundHelper.Client.addSound("rancidresources", "poop1.ogg");
		SoundHelper.Client.addSound("rancidresources", "poop2.ogg");
	}

	@Override
	public void afterClientStart() {

	}
}
