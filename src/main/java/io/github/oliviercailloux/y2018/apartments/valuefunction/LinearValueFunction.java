package io.github.oliviercailloux.y2018.apartments.valuefunction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Range;


/**
 * Class which enables the user to get the subjective value of a double given in argument.
 *
 */
public class LinearValueFunction implements PartialValueFunction<Double> {

	private Range<Double> interval ;
	private final static Logger LOGGER = LoggerFactory.getLogger(LinearValueFunction.class);
	
	/**
	 * Create a guava interval between min and max.
	 * @param min lower bound of the interval
	 * @param max upper bound of the interval
	 */
	public LinearValueFunction (double min, double max) {
		if (min == max) {
			LOGGER.error("The upper bound is equal to the lower bound in the constructor of the LinearValueFunction.");
			throw new IllegalArgumentException("The upper bound can't be equal to the lower bound.");
		}
		interval = Range.closed(min, max);
		LOGGER.info("The interval ["+min+","+max+"] "+" has been set with success in the LinearValueFunction class.");
	}

	@Override
	public double getSubjectiveValue(Double objectiveData) throws IllegalArgumentException {
		return (objectiveData - interval.lowerEndpoint())/(interval.upperEndpoint() - interval.lowerEndpoint());
	}

	@Override
	public Double apply(Double objectiveData) {
		return getSubjectiveValue(objectiveData);
	}
	
}
