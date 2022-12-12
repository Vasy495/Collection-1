package transport;

public abstract class Transport {
    private String brand;
    private String model;
    private float engineVolume;

    public abstract void defineType();

    public abstract void startMovement();

    public abstract void stopMovement();

    public Transport(String brand, String model, float engineVolume) {
        setBrand(brand);
        setModel(model);
        setEngineVolume(engineVolume);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = ValidationUtils.validOfDefault(brand);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = ValidationUtils.validOfDefault(model);
    }

    public float getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(float engineVolume) {
        this.engineVolume = ValidationUtils.validOfFloatDefault(engineVolume);
    }

    public abstract boolean service();
}
