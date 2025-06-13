import { useRef, useState } from 'react';
import '../../css/author.css';

function AuthorDashboard() {
    // State to track if the sidebar/overlay is "closed" (meaning the overlay is hidden and sidebar is collapsed)
    const [isClosed, setIsClosed] = useState(true);

    // Refs to access the DOM elements directly
    const overlayRef = useRef(null);
    const wrapperRef = useRef(null);
    /**
       * Handles the click event on the hamburger icon.
       * This function toggles the state which controls:
       * 1. The visual state of the hamburger icon (is-closed/is-open classes).
       * 2. The visibility of the overlay.
       * 3. The 'toggled' class on the main wrapper, which controls the sidebar's open/close state.
       */
    const handleHamburgerClick = () => {
        // Toggle the 'isClosed' state
        const newState = !isClosed;
        setIsClosed(newState);

        // Update overlay visibility based on the new state
        if (overlayRef.current) {
            overlayRef.current.style.display = newState ? 'none' : 'block';
        }

        // Toggle the 'toggled' class on the #wrapper element
        // This is because the hamburger button also has data-toggle="offcanvas" in the original jQuery
        if (wrapperRef.current) {
            wrapperRef.current.classList.toggle('toggled');
        }
    };

    return (
        <div>
            <div id="wrapper" ref={wrapperRef}>
                <div
                    className="overlay"
                    ref={overlayRef}
                    style={{ display: isClosed ? 'none' : 'block' }}
                ></div>

                {/* Sidebar */}
                <nav className="navbar navbar-inverse fixed-top" id="sidebar-wrapper" role="navigation">
                    <ul className="nav sidebar-nav">
                        <div className="sidebar-header">
                            <div className="sidebar-brand">
                                <a href="#">Brand</a>
                            </div>
                        </div>
                        <li><a href="#home"> Home</a></li>
                        <li><a href="#about">About</a></li>
                        <li><a href="#events">Events</a></li>
                        <li><a href="#team">Team</a></li>
                        <li className="dropdown">
                            {/* Dropdown toggle for 'Works' */}
                            <a href="#works" className="dropdown-toggle" data-toggle="dropdown">Works <span className="caret"></span></a>
                            {/* Dropdown menu */}
                            <ul className="dropdown-menu animated fadeInLeft" role="menu">
                                <div className="dropdown-header">Dropdown heading</div>
                                <li><a href="#pictures">Pictures</a></li>
                                <li><a href="#videos">Videeos</a></li>
                                <li><a href="#books">Books</a></li>
                                <li><a href="#art">Art</a></li>
                                <li><a href="#awards">Awards</a></li>
                            </ul>
                        </li>
                        <li><a href="#services">Services</a></li>
                        <li><a href="#contact">Contact</a></li>
                        <li><a href="#followme">Follow me</a></li>
                    </ul>
                </nav>
                {/* #sidebar-wrapper */}
                {/* #sidebar-wrapper  */}

                {/* Page Content  */}
                {/* Page Content */}
                <div id="page-content-wrapper">
                    {/* Hamburger button controlled by state and click handler */}
                    <button
                        type="button"
                        className={`hamburger animated fadeInLeft ${isClosed ? 'is-closed' : 'is-open'}`}
                        data-toggle="offcanvas" // This attribute is for jQuery, handled by handleHamburgerClick in React
                        onClick={handleHamburgerClick}
                    >
                        <span className="hamb-top"></span>
                        <span className="hamb-middle"></span>
                        <span className="hamb-bottom"></span>
                    </button>
                    <div className="container">
                        <div className="row">
                            <div className="col-lg-8 col-lg-offset-2">
                                <h1 className="text-3xl font-bold mb-4">Fancy Toggle Sidebar Navigation</h1>
                                <p className="mb-4">Bacon ipsum dolor sit amet tri-tip shoulder tenderloin shankle. Bresaola tail pancetta ball tip doner meatloaf corned beef. Kevin pastrami tri-tip prosciutto ham hock pork belly bacon pork loin salami pork chop shank corned beef tenderloin meatball cow. Pork bresaola meatloaf tongue, landjaeger tail andouille strip steak tenderloin sausage chicken tri-tip. Pastrami tri-tip kielbasa sausage porchetta pig sirloin boudin rump meatball andouille chuck tenderloin biltong shank </p>
                                <p className="mb-4">Pig meatloaf bresaola, spare ribs venison short loin rump pork loin drumstick jowl meatball brisket. Landjaeger chicken fatback pork loin doner sirloin cow short ribs hamburger shoulder salami pastrami. Pork swine beef ribs t-bone flank filet mignon, ground round tongue. Tri-tip cow turducken shank beef shoulder bresaola tongue flank leberkas ball tip.</p>
                                <p className="mb-4">Filet mignon brisket pancetta fatback short ribs short loin prosciutto jowl turducken biltong kevin pork chop pork beef ribs bresaola. Tongue beef ribs pastrami boudin. Chicken bresaola kielbasa strip steak biltong. Corned beef pork loin cow pig short ribs boudin bacon pork belly chicken andouille. Filet mignon flank turkey tongue. Turkey ball tip kielbasa pastrami flank tri-tip t-bone kevin landjaeger capicola tail fatback pork loin beef jerky.</p>
                                <p className="mb-4">Chicken ham hock shankle, strip steak ground round meatball pork belly jowl pancetta sausage spare ribs. Pork loin cow salami pork belly. Tri-tip pork loin sausage jerky prosciutto t-bone bresaola frankfurter sirloin pork chop ribeye corned beef chuck. Short loin hamburger tenderloin, landjaeger venison porchetta strip steak turducken pancetta beef cow leberkas sausage beef ribs. Shoulder ham jerky kielbasa. Pig doner short loin pork chop. Short ribs frankfurter rump meatloaf.</p>
                                <p>Filet mignon biltong chuck pork belly, corned beef ground round ribeye short loin rump swine. Hamburger drumstick turkey, shank rump biltong pork loin jowl sausage chicken. Rump pork belly fatback ball tip swine doner pig. Salami jerky cow, boudin pork chop sausage tongue andouille turkey.</p>
                            </div>
                        </div>
                    </div>
                </div>
                {/* /#page-content-wrapper */}
            </div>
            {/* /#wrapper */}
            {/* /#page-content-wrapper  */}

        </div>

    )
}

export default AuthorDashboard;