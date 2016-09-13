public class MyDate
{

    // ------------------------------------------------------------------------------------- ATTRIBUTES

    private int day;
    private int month;
    private int year;

    // ------------------------------------------------------------------------------------- CONSTRUCTOR

    public MyDate ()
    {
        // Default constructor HERE!
    }

    public MyDate (int newDay, int newMonth, int newYear)
    {
        this.setDay(newDay);
        this.setMonth(newMonth);
        this.setYear(newYear);
    }

    // ------------------------------------------------------------------------------------- METHODS

    public int getDay()
    {
        return day;
    }

    public void setDay(int day)
    {
        this.day = day;
    }

    public int getMonth()
    {
        return month;
    }

    public void setMonth(int month)
    {
        this.month = month;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public String toString ()
    {
        return (this.getDay() + "." + this.getMonth() + "." + this.getYear());
    }

    public boolean earlierThan (MyDate compared)
    {
        boolean earlier;
        if ( this.getYear() < compared.getYear() )
        {
            earlier = true;
        }
        else if ( this.getYear() == compared.getYear() )
        {
            if ( this.getMonth() < compared.getMonth() )
            {
                earlier = true;
            }
            else if ( this.getMonth() == compared.getMonth() )
            {
                if ( this.getDay() < compared.getDay() )
                {
                    earlier = true;
                }
                else
                {
                    earlier = false;
                }
            }
            else
            {
                earlier = false;
            }
        }
        else
        {
            earlier = false;
        }

        return earlier;
    }

    public void advance ()
    {
        this.setDay( this.getDay() + 1 );
        if ( this.getDay() >30 )
        {
            this.setDay (1);
            this.setMonth( this.getMonth() + 1 );
            if( this.getMonth() > 12 )
            {
                this.setMonth (1);
                this.setYear ( this.getYear() + 1 );
            }
        }
    }

    public void advance (int numOfDays) /* Overloaded version of the previous one! Notice how it uses the previous one.
                                           This is code reuse. This is quite awesome! We would have to think of many
                                           conditions, quite a big deal, if we were going to treat with this stand
                                           alone: How would you fix the months/years advance if you had to deal with
                                           many days? Don't need to think about it!

                                           ALWAYS DO FUCKING CODE REUSE! */
    {
        for(int i = 1; i <= numOfDays; i = i + 1)
        {
            this.advance();
        }
    }

    public MyDate afterNumOfDays (int days) // A method that CREATES a new object!
    {
        MyDate newDate = new MyDate (this.getDay(), this.getMonth(), this.getYear());
        newDate.advance(days);
        return newDate;
    }

    // ------------------------------------------------------------------------------------- TEST MAIN

    public static void main (String [] args)
    {
        MyDate day = new MyDate (25, 2, 2011);
        MyDate newDate = day.afterNumOfDays(7);
        for(int i = 1; i <= 7; i = i + 1)
        {
            System.out.println( "Friday after " + i + " weeks is " + newDate );
            newDate = newDate.afterNumOfDays(7);
        }
        System.out.println("This week's Friday is " + day);
        System.out.println("The date 790 days from this week's Friday is " + day.afterNumOfDays(790));
    }

}
