package ie.tudublin;

public class Main
{

	public static void helloProcessing()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new HelloProcessing());
    }

	public static void main(String[] args)
	{
		System.out.println("Hello world");
		
		Cat ginger = new Cat();
		ginger.setName("Ginger");
		ginger.setnumLives(9);

		helloProcessing();

		while(ginger.getnumLives() > 0)
		{
			ginger.Kill();
		}
	}
	
}