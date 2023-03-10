export default function TCHome(){

    const styles = {
      backgroundImage: 'url(https://images.pexels.com/photos/3571563/pexels-photo-3571563.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1)',
      backgroundRepeat: 'no-repeat',
      backgroundSize: 'cover',
      height: '100vh',
      fontSize: '25px',
      color: 'white',
      fontWeight: 'bold'
    };
  
    const containerStyles = {
      display: 'flex',
      justifyContent: 'center',
      alignItems: 'center',
      height: '100%',
      flexDirection: 'column',
      textAlign: 'center'
    }
  
    return(
      <div style={styles}>
        <div style={containerStyles}>
          <h1>Welcome to 3C</h1>
          <p>The premier freelancing platform for businesses and talented professionals alike.</p>
          <ul>
            <li>A wide range of talented professionals to choose from, including Maid, designers, developers, and more.</li>
            <li>Powerful tools and features to help you communicate with your freelancers, set milestones, and track progress.</li>
            <li>24/7 customer support to help you with any issues or questions that may arise.</li>
          </ul>
          <p>Whether you're a small business looking to grow, or a freelancer looking to expand your client base, 3C is the perfect platform for you. Join us today and experience the power of freelancing like never before!</p>
        </div>
      </div>
    )
  }
