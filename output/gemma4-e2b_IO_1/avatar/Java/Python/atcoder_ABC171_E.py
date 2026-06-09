def analyze_data(data):
    """
    Analyzes a list of numbers.

    Args:
        data: A list of numbers.

    Returns:
        A dictionary containing the sum, average, and count of the numbers.
    """
    if not data:
        return {"sum": 0, "average": 0, "count": 0}

    total_sum = sum(data)
    count = len(data)
    average = total_sum / count

    return {
        "sum": total_sum,
        "average": average,
        "count": count
    }

# Example usage:
# You need to provide the data you want to analyze.
# For demonstration, let's create a sample list.
sample_data = [10, 20, 30, 40, 50]
analysis_result = analyze_data(sample_data)
print(analysis_result)

# Example with a larger dataset:
large_sample_data = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
large_analysis_result = analyze_data(large_sample_data)
print(large_analysis_result)
