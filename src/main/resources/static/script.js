document.getElementById('login-form').addEventListener('submit', function (e) {
    e.preventDefault();

    const usernameInput = document.getElementById('username');
    const passwordInput = document.getElementById('password');
    const errorMsg = document.getElementById('error-msg');

    const username = usernameInput.value.trim();
    const password = passwordInput.value.trim();

    // Reset error
    errorMsg.textContent = '';
    usernameInput.style.borderColor = '#d1d5db';
    passwordInput.style.borderColor = '#d1d5db';

    if (!username || !password) {
        errorMsg.textContent = 'Please fill in both fields.';
        return;
    }

    // Mock Authentication Logic
    // Valid credentials: testuser / Password123
    if (username === 'testuser' && password === 'Password123') {
        // Successful login
        window.location.href = 'dashboard.html?user=' + encodeURIComponent(username);
    } else {
        // Invalid login
        errorMsg.textContent = 'Invalid username or password.';
        usernameInput.style.borderColor = '#ef4444';
        passwordInput.style.borderColor = '#ef4444';
    }
});
