#[no_mangle]
pub extern  fn sample_add( i: i32) ->i32 {
    i+2
}

#[no_mangle]
pub extern fn sieve_liner(n: usize) -> usize{
    let mut primes = vec![];
    let mut d = vec![0usize; n + 1];
    for i in 2..n + 1 {
        if d[i] == 0 {
            primes.push(i);
            d[i] = i;
        }
        for p in &primes {
            if p * i > n {
                break;
            } 
            d[*p * i] = *p;
        }
    }
    
    primes.len() 
}