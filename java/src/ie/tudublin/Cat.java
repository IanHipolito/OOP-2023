package ie.tudublin;

public class Cat
{
	String name;
	private int numLives;
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public Cat()
	{
	}
	
	public Cat(String name)
	{
	}
	
	public int getnumLives()
	{
		return numLives;
	}

	public void setnumLives(int numLives)
	{
		this.numLives = 9;
	}

	public void Kill()
	{
		this.numLives = this.numLives - 1;
		if(this.numLives > 0)
		{
			System.out.println("Ouch");
		}
		else
		{
			System.out.println("Dead");
		}
	}
}