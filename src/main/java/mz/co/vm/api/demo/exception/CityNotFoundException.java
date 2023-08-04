package mz.co.vm.api.demo.exception;

/**
 * 
 * @author Humberto Pfumo
 * 
 * This exception indicates that a unit of code could
 *  not continue execution, due to an invalid name of City or City Not Found.
 */

public class CityNotFoundException extends RuntimeException{

	/**
     * @param countryName - the name of the city for which an invalid or not found value was passed
     */
    public CityNotFoundException(String countryName)
    {
        super("City Not Found or Invalid " + countryName);
    }

}
