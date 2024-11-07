// Simple JavaScript to handle form submission
document.getElementById("contactForm").addEventListener("submit", function(event) {
    event.preventDefault();
    
    const name = document.getElementById("name").value;
    const email = document.getElementById("email").value;
    const message = document.getElementById("message").value;
    
    if (name && email && message) {
        alert("Cảm ơn bạn, " + name + "! Tin nhắn của bạn đã được gửi.");
        // Clear the form after submission
        document.getElementById("contactForm").reset();
    } else {
        alert("Vui lòng điền đầy đủ thông tin.");
    }
});
