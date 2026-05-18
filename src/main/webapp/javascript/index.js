let current = 0;
const slides = document.querySelectorAll('.slide');
const dotsContainer = document.getElementById('heroDots');

slides.forEach((_, i) => {
    const dot = document.createElement('span');
    dot.classList.add('dot');
    if (i === 0) dot.classList.add('active');
    dot.onclick = () => goToSlide(i);
    dotsContainer.appendChild(dot);
});

function updateSlider() {
    slides.forEach(s => s.classList.remove('active'));
    document.querySelectorAll('.dot').forEach(d => d.classList.remove('active'));
    slides[current].classList.add('active');
    document.querySelectorAll('.dot')[current].classList.add('active');
}

function nextSlide() {
    current = (current + 1) % slides.length;
    updateSlider();
}

function prevSlide() {
    current = (current - 1 + slides.length) % slides.length;
    updateSlider();
}

function goToSlide(index) {
    current = index;
    updateSlider();
}

setInterval(nextSlide, 4000);

function slideLeft() {
    document.getElementById('movieGrid').scrollBy({
        left: -250,
        behavior: 'smooth'
    });
}

function slideRight() {
    document.getElementById('movieGrid').scrollBy({
        left: 250,
        behavior: 'smooth'
    });
}