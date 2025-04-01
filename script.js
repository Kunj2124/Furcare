const scroll = new LocomotiveScroll({
    el: document.querySelector('#main'),
    smooth: true
});

function toggleFAQ(index) {
    const content = document.getElementById(`faq${index}`);
    const isVisible = content.style.display === 'block';
    
    // Hide all FAQ content
    const faqContents = document.querySelectorAll('.faq-content');
    faqContents.forEach(faq => faq.style.display = 'none');
  
    // Toggle visibility of clicked FAQ content
    content.style.display = isVisible ? 'none' : 'block';
}

function page4Animation(){
    var elemC = document.querySelector("#elem-container")
    var fixed = document.querySelector("#fixed-image")
    elemC.addEventListener("mouseenter", function(){
        fixed.style.display = "block"
    })
    elemC.addEventListener("mouseleave", function(){
        fixed.style.display = "none"
    })

var elems = document.querySelectorAll(".elem")
elems.forEach(function(e){
    e.addEventListener("mouseenter", function(){
        var image = e.getAttribute("data-image")
        fixed.style.backgroundImage = `url(${image})`
    })
})
}

function swiperAnimation(){
    var swiper = new Swiper(".mySwiper", {
        slidesPerView: "auto",
        centeredSlides: true,
        spaceBetween: 100,
    });
}

swiperAnimation()
page4Animation()

var loader = document.querySelector("#loader")
setTimeout(function(){
    loader.style.top = "-100%"
},1000)

// Get the contact h4 and dropdown element
var contactH4 = document.getElementById('contact');
var dropdown = document.getElementById('dropdown');

// Add click event listener to toggle the dropdown
contactH4.addEventListener('click', function() {
    if (dropdown.style.display === "none" || dropdown.style.display === "") {
        dropdown.style.display = "block";  // Show dropdown
    } else {
        dropdown.style.display = "none";  // Hide dropdown
    }
});

// Optionally, close dropdown if clicking outside
document.addEventListener('click', function(event) {
    var isClickInside = contactH4.contains(event.target) || dropdown.contains(event.target);
    if (!isClickInside) {
        dropdown.style.display = "none";  // Hide dropdown if clicked outside
    }
});

document.addEventListener("DOMContentLoaded", function() {
    // Simulate loading time (you can remove this setTimeout in production)
        setTimeout(function() {
            document.body.classList.add("loaded");
        }, 3000); 
    // For production use this to hide loader when all content is loaded
    // window.addEventListener("load", function() {
    //     document.body.classList.add("loaded");
    // });
    });
    // Show scroll up button when scrolled down
    window.addEventListener('scroll', function() {
        const scrollUpBtn = document.getElementById('scrollUpBtn');  
        if (window.scrollY > 200) {
            scrollUpBtn.style.display = 'block';
        } else {
            scrollUpBtn.style.display = 'none';
        }
    });

    // Flip back the card when clicking outside
    document.addEventListener('click', function(event) {
        const flippedCards = document.querySelectorAll('.swiper-slide.flipped');
        flippedCards.forEach(card => {
            if (!card.contains(event.target)) {
                card.classList.remove('flipped');
            }
        });
    });


    function flipCard(element) {
        element.classList.toggle('flipped');
    }