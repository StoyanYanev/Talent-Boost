Write the new software for your local municipality. The clerks need to be able
to store information on all residents - Names, Personal ID number (ЕГН),
Permanent address.

-   The data for each person should be stored in a separate, uniquely named file
    or one file only. (you choose)

-   The system should provide commands for adding, modifying, searching and
    deleting residents.

-   The input is from console.

Example:

>   \#add 23535345/Ivan Ivanov/Sofia ...

>   \-\> Added record 5

>   \#search idNumber=235...

>   \-\> 23535345/Ivan Ivanov/Sofia ...

>   \#search name=Ivan Ivanov

>   \#modify 5 23535345/Ivan Stoyanov/Sofia ..

>   \-\> Modified record 5

>   \#delete 5
