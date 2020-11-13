#[no_mangle]
pub extern  fn sample_add( i: i32) ->i32 {
    i+2
}

#[no_mangle]
pub extern fn sieve_liner(n: i32) -> i32{
    let mut primes = vec![];
    let mut d = vec![0i32; n as usize + 1];
    
    for i in 2..n + 1 {
        if d[i as usize] == 0 {
            primes.push(i);
            d[i as usize] = i;
        }
        for p in &primes {
            if p * i > n {
                break;
            } 
            d[(*p * i) as usize] = *p;
        }
    }
    
    primes.len() as i32
}