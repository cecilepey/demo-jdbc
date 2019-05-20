/**
 * 
 */
package fr.diginamic.exception;

/**
 * Classe pour gérer les exceptions
 * 
 * @author Cécile Peyras
 *
 */
public class TechnicalException extends RuntimeException {

	/**
	 * Constructeur
	 * 
	 * @param arg0
	 */
	public TechnicalException(String message) {
		super(message);

	}

	/**
	 * Constructeur
	 * 
	 * @param arg0
	 * @param arg1
	 */
	public TechnicalException(String message, Throwable cause) {
		super(message, cause);

	}

}
