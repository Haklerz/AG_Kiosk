package no.ntnu.ag;

/**
 * Kiosk
 */
public class Kiosk {
    private LiteratureRegistry registry;

    public Kiosk() {
        this.registry = new LiteratureRegistry();
    }

	public void init() {
        this.registry.fillDummies();
	}
}