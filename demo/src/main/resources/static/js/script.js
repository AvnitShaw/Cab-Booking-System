function calculateCost() {
    // Get input values
    const kilometers = document.getElementById('kilometers').value;
    const rate =10;

    // Validate input
    if (kilometers === '') {
        alert('Please fill fields.');
        return;
    }

    // Calculate total cost
    const totalCost = kilometers * rate;

    // Display the result
    document.getElementById('totalCost').innerText = totalCost.toFixed(2);
}